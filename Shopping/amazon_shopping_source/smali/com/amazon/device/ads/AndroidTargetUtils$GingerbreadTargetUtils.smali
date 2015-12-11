.class Lcom/amazon/device/ads/AndroidTargetUtils$GingerbreadTargetUtils;
.super Ljava/lang/Object;
.source "AndroidTargetUtils.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x9
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AndroidTargetUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "GingerbreadTargetUtils"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 261
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static editorApply(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p0, "editor"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 269
    invoke-interface {p0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 270
    return-void
.end method
