.class public interface abstract Lcom/amazon/mShop/android/platform/services/api/IAndroidServiceProxy;
.super Ljava/lang/Object;
.source "IAndroidServiceProxy.java"


# virtual methods
.method public abstract superDump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
.end method

.method public abstract superOnConfigurationChanged(Landroid/content/res/Configuration;)V
.end method

.method public abstract superOnCreate()V
.end method

.method public abstract superOnDestroy()V
.end method

.method public abstract superOnLowMemory()V
.end method

.method public abstract superOnRebind(Landroid/content/Intent;)V
.end method

.method public abstract superOnStart(Landroid/content/Intent;I)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract superOnStartCommand(Landroid/content/Intent;II)I
.end method

.method public abstract superOnTaskRemoved(Landroid/content/Intent;)V
.end method

.method public abstract superOnTrimMemory(I)V
.end method

.method public abstract superOnUnbind(Landroid/content/Intent;)Z
.end method
