package com.code.zzq.myapp.base;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

/**
 * 数据库迁移实体类，版本升级时需要修改版本号和添加对应的参数到注释部分
 * Created by zzqybyb1986 on 2017/11/21.
 */

public class MyRealmMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
//        RealmSchema schema = realm.getSchema();
//        if (oldVersion == 0) {
//            schema.remove("RealmSignModel");
//            oldVersion++;
//        }
    }
}
