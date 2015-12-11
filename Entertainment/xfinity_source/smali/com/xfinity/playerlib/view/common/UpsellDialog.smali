.class public Lcom/xfinity/playerlib/view/common/UpsellDialog;
.super Lcom/comcast/cim/android/view/common/CALDialogFragment;
.source "UpsellDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
    }
.end annotation


# static fields
.field private static final TITLE_BUILDER:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;


# instance fields
.field private androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    invoke-direct {v0}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/view/common/UpsellDialog;->TITLE_BUILDER:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;-><init>()V

    .line 29
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 139
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/common/UpsellDialog;)Landroid/net/Uri;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/common/UpsellDialog;

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getUpsellUri()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method private getUpsellUri()Landroid/net/Uri;
    .locals 4

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "providerCode"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 111
    .local v0, "providerCode":Ljava/lang/String;
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_default:I

    .line 112
    .local v1, "resId":I
    if-eqz v0, :cond_0

    .line 113
    const-string v2, "d"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 114
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_hbo:I

    .line 136
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    return-object v2

    .line 115
    :cond_1
    const-string v2, "f"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 116
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_starz:I

    goto :goto_0

    .line 117
    :cond_2
    const-string v2, "g"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 118
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_cinemax:I

    goto :goto_0

    .line 119
    :cond_3
    const-string v2, "e"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 120
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_showtime:I

    goto :goto_0

    .line 121
    :cond_4
    const-string v2, "j"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "k"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 122
    :cond_5
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_mi_cine:I

    goto :goto_0

    .line 123
    :cond_6
    const-string v2, "ab"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 124
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_bollywood:I

    goto :goto_0

    .line 125
    :cond_7
    const-string v2, "ai"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 126
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_tmc:I

    goto :goto_0

    .line 127
    :cond_8
    const-string v2, "h"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 128
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_encore:I

    goto :goto_0

    .line 129
    :cond_9
    const-string v2, "bh"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 130
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_vutopia:I

    goto :goto_0

    .line 131
    :cond_a
    const-string v2, "cj"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 132
    sget v1, Lcom/xfinity/playerlib/R$string;->url_upsell_streampix:I

    goto :goto_0
.end method

.method public static newInstance(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/common/UpsellDialog;
    .locals 3
    .param p0, "args"    # Landroid/os/Bundle;

    .prologue
    .line 32
    const-string v1, "tag"

    const-string v2, "inputPromptDlg"

    invoke-virtual {p0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    new-instance v0, Lcom/xfinity/playerlib/view/common/UpsellDialog;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;-><init>()V

    .line 34
    .local v0, "dialog":Lcom/xfinity/playerlib/view/common/UpsellDialog;
    invoke-virtual {v0, p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->setArguments(Landroid/os/Bundle;)V

    .line 36
    return-object v0
.end method

.method public static newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/view/common/UpsellDialog;
    .locals 3
    .param p0, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 50
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 51
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "providerCode"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProviderCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    const-string v1, "upsellType"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 53
    invoke-static {v0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v1

    return-object v1
.end method

.method public static newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/Throwable;)Lcom/xfinity/playerlib/view/common/UpsellDialog;
    .locals 3
    .param p0, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "errorThrowable"    # Ljava/lang/Throwable;

    .prologue
    .line 40
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 41
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "providerCode"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProviderCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    const-string v1, "upsellType"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 43
    instance-of v1, p2, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    if-eqz v1, :cond_0

    .line 44
    const-string v1, "titleSuffix"

    sget-object v2, Lcom/xfinity/playerlib/view/common/UpsellDialog;->TITLE_BUILDER:Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;

    check-cast p2, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    .end local p2    # "errorThrowable":Ljava/lang/Throwable;
    invoke-virtual {v2, p2}, Lcom/comcast/cim/android/view/common/errorformatter/CimHttpErrorTitleBuilder;->getTitleSuffixForThrowable(Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    :cond_0
    invoke-static {v0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v1

    return-object v1
.end method

.method public static newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/view/common/UpsellDialog;
    .locals 4
    .param p0, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 65
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 67
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "providerCode"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v1

    const/4 v3, 0x0

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    const-string v1, "upsellType"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 69
    invoke-static {v0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v1

    return-object v1
.end method

.method public static newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Lcom/xfinity/playerlib/view/common/UpsellDialog;
    .locals 4
    .param p0, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 57
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 59
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "providerCode"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getProviderCodes()Ljava/util/List;

    move-result-object v1

    const/4 v3, 0x0

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    const-string v1, "upsellType"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 61
    invoke-static {v0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 74
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    .line 75
    .local v1, "args":Landroid/os/Bundle;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 77
    .local v0, "additionalArgs":Landroid/os/Bundle;
    const-string v5, "upsellType"

    invoke-virtual {v1, v5}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .line 79
    .local v4, "upsellType":Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->subscription_needed:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 80
    .local v3, "title":Ljava/lang/String;
    const-string v5, "titleSuffix"

    invoke-virtual {v1, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 81
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "titleSuffix"

    invoke-virtual {v1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 83
    :cond_0
    const-string v5, "title"

    invoke-virtual {v0, v5, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    const-string v5, "description"

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->getDescriptionResId()I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->addArguments(Landroid/os/Bundle;)V

    .line 88
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog;->buttonList:Ljava/util/List;

    .line 90
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v5}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isKindleOrFromAmazonStore()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 91
    sget v5, Lcom/xfinity/playerlib/R$string;->dlg_btn_ok:I

    invoke-virtual {p0, v5}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 104
    .local v2, "buttonText":Ljava/lang/String;
    :goto_0
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog;->buttonList:Ljava/util/List;

    new-instance v6, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    new-instance v7, Lcom/comcast/cim/android/view/common/CancellingClickListener;

    invoke-direct {v7}, Lcom/comcast/cim/android/view/common/CancellingClickListener;-><init>()V

    invoke-direct {v6, v2, v7}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v5, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 106
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v5

    return-object v5

    .line 93
    .end local v2    # "buttonText":Ljava/lang/String;
    :cond_1
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog;->buttonList:Ljava/util/List;

    new-instance v6, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$string;->order_now:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    new-instance v8, Lcom/xfinity/playerlib/view/common/UpsellDialog$1;

    invoke-direct {v8, p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog$1;-><init>(Lcom/xfinity/playerlib/view/common/UpsellDialog;)V

    invoke-direct {v6, v7, v8}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v5, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 101
    sget v5, Lcom/xfinity/playerlib/R$string;->dlg_btn_cancel:I

    invoke-virtual {p0, v5}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getString(I)Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "buttonText":Ljava/lang/String;
    goto :goto_0
.end method
