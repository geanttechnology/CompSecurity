.class public Lcom/xfinity/playerlib/view/browsenetworks/NetworksActivity;
.super Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.source "NetworksActivity.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 20
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_networks_browse:I

    return v0
.end method

.method public getSearchBackIcon()I
    .locals 1

    .prologue
    .line 15
    sget v0, Lcom/xfinity/playerlib/R$drawable;->ico_back_networks:I

    return v0
.end method
