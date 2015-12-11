.class public Lcom/xfinity/playerlib/view/browseprograms/MoviesActivity;
.super Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.source "MoviesActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/view/flow/FilterRequestObserver;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/MoviesActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/MoviesActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 31
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_movie_browse:I

    return v0
.end method

.method public getSearchBackIcon()I
    .locals 1

    .prologue
    .line 19
    sget v0, Lcom/xfinity/playerlib/R$drawable;->ico_back_movie:I

    return v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 36
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/MoviesSpeechRecognizer;

    return-object v0
.end method

.method public showFilter(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "filterBundle"    # Landroid/os/Bundle;

    .prologue
    .line 24
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/xfinity/playerlib/view/browseprograms/MoviesFilterDialog;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 25
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {v0, p1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 26
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/MoviesActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 27
    return-void
.end method
