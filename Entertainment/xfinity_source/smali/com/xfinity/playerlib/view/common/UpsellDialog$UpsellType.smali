.class public final enum Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
.super Ljava/lang/Enum;
.source "UpsellDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/common/UpsellDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "UpsellType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

.field public static final enum DOWNLOAD:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

.field public static final enum PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

.field public static final enum PLAY_DOWNLOADED:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

.field public static final enum PLAY_FROM_HISTORY:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

.field public static final enum PLAY_FROM_PLAYER:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;


# instance fields
.field private descriptionResId:I


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 140
    new-instance v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    const-string v1, "PLAYBACK"

    sget v2, Lcom/xfinity/playerlib/R$string;->subscription_required_playback:I

    invoke-direct {v0, v1, v3, v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .line 141
    new-instance v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    const-string v1, "DOWNLOAD"

    sget v2, Lcom/xfinity/playerlib/R$string;->subscription_required_download:I

    invoke-direct {v0, v1, v4, v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->DOWNLOAD:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .line 142
    new-instance v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    const-string v1, "PLAY_DOWNLOADED"

    sget v2, Lcom/xfinity/playerlib/R$string;->subscription_invalid_msg:I

    invoke-direct {v0, v1, v5, v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_DOWNLOADED:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .line 143
    new-instance v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    const-string v1, "PLAY_FROM_HISTORY"

    sget v2, Lcom/xfinity/playerlib/R$string;->subscription_invalid_msg:I

    invoke-direct {v0, v1, v6, v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_HISTORY:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .line 144
    new-instance v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    const-string v1, "PLAY_FROM_PLAYER"

    sget v2, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_subscription_required:I

    invoke-direct {v0, v1, v7, v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_PLAYER:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .line 139
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    sget-object v1, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->DOWNLOAD:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_DOWNLOADED:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_HISTORY:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_PLAYER:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    aput-object v1, v0, v7

    sput-object v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->$VALUES:[Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "descriptionResId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 148
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 149
    iput p3, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->descriptionResId:I

    .line 150
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 139
    const-class v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
    .locals 1

    .prologue
    .line 139
    sget-object v0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->$VALUES:[Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    return-object v0
.end method


# virtual methods
.method public getDescriptionResId()I
    .locals 1

    .prologue
    .line 153
    iget v0, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->descriptionResId:I

    return v0
.end method
