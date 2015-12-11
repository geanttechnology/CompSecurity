.class public abstract Lcom/amazon/android/webkit/AmazonWebSettings;
.super Ljava/lang/Object;
.source "AmazonWebSettings.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/webkit/AmazonWebSettings$RenderPriority;,
        Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;,
        Lcom/amazon/android/webkit/AmazonWebSettings$ZoomDensity;
    }
.end annotation


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract getUserAgentString()Ljava/lang/String;
.end method

.method public abstract setBuiltInZoomControls(Z)V
.end method

.method public abstract setDatabaseEnabled(Z)V
.end method

.method public abstract setDefaultZoom(Lcom/amazon/android/webkit/AmazonWebSettings$ZoomDensity;)V
.end method

.method public abstract setDomStorageEnabled(Z)V
.end method

.method public abstract setDoubleTapToZoomEnabled(Z)V
.end method

.method public abstract setJavaScriptCanOpenWindowsAutomatically(Z)V
.end method

.method public abstract setJavaScriptEnabled(Z)V
.end method

.method public abstract setRenderPriority(Lcom/amazon/android/webkit/AmazonWebSettings$RenderPriority;)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract setSaveFormData(Z)V
.end method

.method public abstract setSavePassword(Z)V
.end method

.method public abstract setSupportZoom(Z)V
.end method

.method public abstract setTextSize(Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;)V
.end method

.method public abstract setTextZoom(I)V
.end method

.method public abstract setUserAgentString(Ljava/lang/String;)V
.end method
