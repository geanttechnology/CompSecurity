.class public Lcom/xfinity/playerlib/view/featured/FeaturedActivity;
.super Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.source "FeaturedActivity.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 10
    const-class v0, Lcom/xfinity/playerlib/view/featured/FeaturedActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/featured/FeaturedActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 24
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_featured:I

    return v0
.end method

.method public getSearchBackIcon()I
    .locals 1

    .prologue
    .line 14
    sget v0, Lcom/xfinity/playerlib/R$drawable;->ico_back_featured:I

    return v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    return-object v0
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 29
    invoke-super {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->onResumeInternal()V

    .line 30
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedActivity;->checkTalkBackModeOnResume()V

    .line 31
    return-void
.end method
