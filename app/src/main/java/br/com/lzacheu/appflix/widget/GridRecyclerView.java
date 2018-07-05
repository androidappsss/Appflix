package br.com.lzacheu.appflix.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.GridLayoutAnimationController;

/**
 * Created by luiszacheu on 05/07/18.
 *
 * based on https://proandroiddev.com/enter-animation-using-recyclerview-and-layoutanimation-part-2-grids-688829b1d29b
 */
public class GridRecyclerView extends RecyclerView {

    public GridRecyclerView(Context context) {
        super(context);
    }

    public GridRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GridRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void attachLayoutAnimationParameters(View child, ViewGroup.LayoutParams params, int index, int count) {

        final LayoutManager layoutManager = getLayoutManager();
        if (getAdapter() != null && layoutManager instanceof GridLayoutManager) {
            GridLayoutAnimationController.AnimationParameters animationParameters = (GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;

            if (animationParameters == null) {
                //If there are no animation parameters, create new once and attach them to the LayoutParams
                animationParameters = new GridLayoutAnimationController.AnimationParameters();
                params.layoutAnimationParameters = animationParameters;
            }

            //Next we are updating the parameters

            //Set the number of items in the RecyclerView and the index of this item
            animationParameters.count = count;
            animationParameters.index = index;

            // Calculate the number of columns and rows in the grid
            final int columns = ((GridLayoutManager) layoutManager).getSpanCount();
            animationParameters.columnsCount = columns;
            animationParameters.rowsCount = count / columns;

            //Calculate the column/row position in the grid
            final int invertedIndex = count - 1 - index;
            animationParameters.column = columns - 1 - (invertedIndex % columns);
            animationParameters.row = animationParameters.rowsCount - 1 - invertedIndex / columns;

        } else {
            super.attachLayoutAnimationParameters(child, params, index, count);
        }
    }
}
