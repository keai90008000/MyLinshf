package com.example.uu.mylinshf.bean;

import java.util.List;

/**封装bean
 * Created by 陈驰 on 2017/5/4.
 */

public class News {
    private int limit;
    private List<OthersBean> others;
    private List<?> subscribed;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<OthersBean> getOthers() {
        return others;
    }

    public void setOthers(List<OthersBean> others) {
        this.others = others;
    }

    public List<?> getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(List<?> subscribed) {
        this.subscribed = subscribed;
    }

    public static class OthersBean {
        /**
         * color : 15007
         * description : 了解自己和别人，了解彼此的欲望和局限。
         * id : 13
         * name : 日常心理学
         * thumbnail : http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg
         */

        private int color;
        private String description;
        private int id;
        private String name;
        private String thumbnail;

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }
}
