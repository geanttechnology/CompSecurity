.class public Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;
.super Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.source "KidsActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/view/flow/FilterRequestObserver;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;-><init>()V

    return-void
.end method

.method private addExtras()V
    .locals 6

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 28
    .local v2, "intent":Landroid/content/Intent;
    const/4 v1, 0x0

    .line 30
    .local v1, "info":Landroid/content/pm/ActivityInfo;
    :try_start_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v4

    const/16 v5, 0x81

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getActivityInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 35
    :goto_0
    if-eqz v1, :cond_0

    .line 36
    const-string v3, "label"

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    iget v5, v1, Landroid/content/pm/ActivityInfo;->labelRes:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 39
    :cond_0
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;->setIntent(Landroid/content/Intent;)V

    .line 40
    return-void

    .line 31
    :catch_0
    move-exception v0

    .line 32
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Caught name not found exception"

    invoke-interface {v3, v4, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 49
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_kids_programs:I

    return v0
.end method

.method public getSearchBackIcon()I
    .locals 1

    .prologue
    .line 44
    sget v0, Lcom/xfinity/playerlib/R$drawable;->ico_back_kids:I

    return v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;->addExtras()V

    .line 22
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->onCreate(Landroid/os/Bundle;)V

    .line 23
    return-void
.end method

.method public showFilter(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "filterBundle"    # Landroid/os/Bundle;

    .prologue
    .line 54
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;-><init>()V

    .line 55
    .local v0, "filterDialog":Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "kidsfilterdialogfragment"

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 56
    return-void
.end method
