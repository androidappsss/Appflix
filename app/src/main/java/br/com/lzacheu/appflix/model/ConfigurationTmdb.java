package br.com.lzacheu.appflix.model;

import java.util.List;

/**
 * Created by luiszacheu on 04/07/18.
 */
public class ConfigurationTmdb {

    private ImagesTmdb images;
    private List<String> changeKeys;


    public ImagesTmdb getImages() {
        return images;
    }

    public void setImages(ImagesTmdb images) {
        this.images = images;
    }

    public List<String> getChangeKeys() {
        return changeKeys;
    }

    public void setChangeKeys(List<String> changeKeys) {
        this.changeKeys = changeKeys;
    }

    @Override
    public String toString() {
        return "ConfigurationTmdb{" +
                "images=" + images +
                ", changeKeys=" + changeKeys +
                '}';
    }


}
