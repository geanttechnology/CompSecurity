.class public final Lcom/penthera/virtuososdk/utility/CommonUtil$FileHelpers;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "FileHelpers"
.end annotation


# direct methods
.method public static getFileSize(Ljava/io/File;)J
    .locals 2
    .param p0, "file"    # Ljava/io/File;

    .prologue
    .line 892
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 894
    invoke-virtual {p0}, Ljava/io/File;->length()J

    move-result-wide v0

    .line 896
    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method
