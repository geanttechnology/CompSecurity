.class public interface abstract Lcom/amazon/device/analytics/configuration/Configuration;
.super Ljava/lang/Object;
.source "Configuration.java"


# virtual methods
.method public abstract getBoolean(Ljava/lang/String;)Ljava/lang/Boolean;
.end method

.method public abstract getInt(Ljava/lang/String;)Ljava/lang/Integer;
.end method

.method public abstract getString(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract optBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;
.end method

.method public abstract optInt(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;
.end method

.method public abstract optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract refresh()V
.end method

.method public abstract registerChangedListener(Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
.end method

.method public abstract registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
.end method

.method public abstract registerRefreshListener(Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;)V
.end method

.method public abstract unregisterChangedListener(Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
.end method

.method public abstract unregisterChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
.end method
