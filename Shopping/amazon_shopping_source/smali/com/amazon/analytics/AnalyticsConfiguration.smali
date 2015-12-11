.class public interface abstract Lcom/amazon/analytics/AnalyticsConfiguration;
.super Ljava/lang/Object;
.source "AnalyticsConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/analytics/AnalyticsConfiguration$Setting;
    }
.end annotation


# virtual methods
.method public abstract getBoolean(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)Z
.end method

.method public abstract getCommaDelimitedStringList(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/analytics/AnalyticsConfiguration$Setting;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getInt(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)I
.end method

.method public abstract registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
.end method
