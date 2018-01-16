package com.code.zzq.myapp.model.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zzqybyb1986 on 2017-12-19.
 */

public class UserInfoModel implements Serializable {
    private String retcode;//返回的状态码
    private boolean hasNext;//是否有下一页
    private String appCode;//本次查询的api名
    private String dataType;//本次查询的api类型名
    private String pageToken;//翻页值
    private List<UserModel> data;

    private static class UserModel implements Serializable{
        private String isVip;//是否是vip
        private int friendCount;//朋友数
        private int id;//用户的ID
        private String biography;//简单自传
        private Integer viewCount;//观看数
        private String idType;// 账号类型：个人的、公众号
        private String gender;//性别
        private String screenName;// 用户显示的名称
        private boolean idVerified;//账号是否验证
        private Integer followCount;//关注数
        private String userName;//用户的用户名
        private String location;//用户所在位置
        private int idGrade;//等级
        private String idVerifiedInfo;//账号验证信息
        private int fansCount;//粉丝数，既被关注数
        private int postCount;//发文数
        private int idExpValue;//经验值
        private int likeCount;//点赞数
        private String url;//本对象的最通用url
        private String avatarUrl;//头像url

        public String getIsVip() {
            return isVip;
        }

        public void setIsVip(String isVip) {
            this.isVip = isVip;
        }

        public int getFriendCount() {
            return friendCount;
        }

        public void setFriendCount(int friendCount) {
            this.friendCount = friendCount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBiography() {
            return biography;
        }

        public void setBiography(String biography) {
            this.biography = biography;
        }

        public Integer getViewCount() {
            return viewCount;
        }

        public void setViewCount(Integer viewCount) {
            this.viewCount = viewCount;
        }

        public String getIdType() {
            return idType;
        }

        public void setIdType(String idType) {
            this.idType = idType;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getScreenName() {
            return screenName;
        }

        public void setScreenName(String screenName) {
            this.screenName = screenName;
        }

        public boolean isIdVerified() {
            return idVerified;
        }

        public void setIdVerified(boolean idVerified) {
            this.idVerified = idVerified;
        }

        public Integer getFollowCount() {
            return followCount;
        }

        public void setFollowCount(Integer followCount) {
            this.followCount = followCount;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getIdGrade() {
            return idGrade;
        }

        public void setIdGrade(int idGrade) {
            this.idGrade = idGrade;
        }

        public String getIdVerifiedInfo() {
            return idVerifiedInfo;
        }

        public void setIdVerifiedInfo(String idVerifiedInfo) {
            this.idVerifiedInfo = idVerifiedInfo;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getPostCount() {
            return postCount;
        }

        public void setPostCount(int postCount) {
            this.postCount = postCount;
        }

        public int getIdExpValue() {
            return idExpValue;
        }

        public void setIdExpValue(int idExpValue) {
            this.idExpValue = idExpValue;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPageToken() {
        return pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public List<UserModel> getData() {
        return data;
    }

    public void setData(List<UserModel> data) {
        this.data = data;
    }
}
