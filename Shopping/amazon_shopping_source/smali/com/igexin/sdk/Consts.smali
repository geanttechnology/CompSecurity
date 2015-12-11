.class public Lcom/igexin/sdk/Consts;
.super Ljava/lang/Object;
.source "Consts.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/igexin/sdk/Consts$ActionPrepareState;
    }
.end annotation


# static fields
.field public static DB_NAME:Ljava/lang/String;

.field public static DB_VERSION:I

.field public static final IMGPATHDIR:Ljava/lang/String;

.field public static MESSAGE_RECEIVER_INTERNAL:I

.field public static PS_SUB_URL:Ljava/lang/String;

.field public static PS_URL:Ljava/lang/String;

.field public static VPUSH_APPID:Ljava/lang/String;

.field public static VPUSH_APPKEY:Ljava/lang/String;

.field public static VPUSH_APPSECRET:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 19
    const-string/jumbo v0, "/api.php?format=json"

    sput-object v0, Lcom/igexin/sdk/Consts;->PS_SUB_URL:Ljava/lang/String;

    .line 20
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "http://sdk.slave.phone.igexin.com"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/igexin/sdk/Consts;->PS_SUB_URL:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/igexin/sdk/Consts;->PS_URL:Ljava/lang/String;

    .line 22
    const-string/jumbo v0, ""

    sput-object v0, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    .line 23
    const-string/jumbo v0, ""

    sput-object v0, Lcom/igexin/sdk/Consts;->VPUSH_APPKEY:Ljava/lang/String;

    .line 24
    const-string/jumbo v0, ""

    sput-object v0, Lcom/igexin/sdk/Consts;->VPUSH_APPSECRET:Ljava/lang/String;

    .line 26
    const-string/jumbo v0, "slavesdk.db"

    sput-object v0, Lcom/igexin/sdk/Consts;->DB_NAME:Ljava/lang/String;

    .line 27
    const/4 v0, 0x1

    sput v0, Lcom/igexin/sdk/Consts;->DB_VERSION:I

    .line 49
    const/4 v0, 0x0

    sput v0, Lcom/igexin/sdk/Consts;->MESSAGE_RECEIVER_INTERNAL:I

    .line 56
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "/Sdk/ImgCache/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/igexin/sdk/Consts;->IMGPATHDIR:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    return-void
.end method
