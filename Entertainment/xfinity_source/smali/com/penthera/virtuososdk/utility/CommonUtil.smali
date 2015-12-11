.class public final Lcom/penthera/virtuososdk/utility/CommonUtil;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$Config;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$FileHelpers;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$HttpUtils;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$Log;,
        Lcom/penthera/virtuososdk/utility/CommonUtil$NetworkHelpers;
    }
.end annotation


# static fields
.field private static iApplicationContext:Landroid/content/Context;


# direct methods
.method public static getApplicationContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 98
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil;->iApplicationContext:Landroid/content/Context;

    return-object v0
.end method

.method public static mimeTypeToExtension(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "aMime"    # Ljava/lang/String;

    .prologue
    .line 917
    const/4 v0, 0x0

    return-object v0
.end method

.method public static setApplicationContext(Landroid/content/Context;)V
    .locals 0
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 102
    sput-object p0, Lcom/penthera/virtuososdk/utility/CommonUtil;->iApplicationContext:Landroid/content/Context;

    .line 103
    return-void
.end method
