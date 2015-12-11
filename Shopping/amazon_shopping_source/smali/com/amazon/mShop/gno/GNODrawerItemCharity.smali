.class public Lcom/amazon/mShop/gno/GNODrawerItemCharity;
.super Lcom/amazon/mShop/gno/GNODrawerItemBase;
.source "GNODrawerItemCharity.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNOItemAdapter$HideableItem;
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mId:Ljava/lang/String;

.field private mIsHiddenCallable:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

.field private mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/Callable;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 40
    .local p3, "callable":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<Ljava/lang/Boolean;>;"
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemBase;-><init>()V

    .line 41
    iput-object p3, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    .line 42
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mContext:Landroid/content/Context;

    .line 43
    iput-object p2, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mId:Ljava/lang/String;

    .line 44
    const-string/jumbo v0, "smi_ac_menu_yc_cycsc"

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->setRefMarker(Ljava/lang/String;)V

    .line 45
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/gno/GNODrawerItemCharity$1;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemCharity;)V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    .line 51
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 52
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/gno/GNODrawerItemCharity;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemCharity;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    return-object v0
.end method

.method private updateText()V
    .locals 2

    .prologue
    .line 91
    invoke-static {}, Lcom/amazon/mShop/smile/SmileHelper;->isSmile()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    iget-object v0, v0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;->text:Landroid/widget/TextView;

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->getCharity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    :cond_0
    :goto_0
    return-void

    .line 96
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    if-eqz v0, :cond_0

    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    iget-object v0, v0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;->text:Landroid/widget/TextView;

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mId:Ljava/lang/String;

    return-object v0
.end method

.method public getIsHiddenCallable()Ljava/util/concurrent/Callable;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    return-object v0
.end method

.method public getType()Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    .locals 1

    .prologue
    .line 74
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->CHARITY:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    return-object v0
.end method

.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "root"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v3, 0x0

    .line 57
    if-nez p1, :cond_0

    .line 58
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mContext:Landroid/content/Context;

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_simple:I

    invoke-virtual {v1, v2, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 59
    .local v0, "view":Landroid/view/View;
    new-instance v1, Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemCharity;Lcom/amazon/mShop/gno/GNODrawerItemCharity$1;)V

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    .line 60
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->drawer_item_title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;->text:Landroid/widget/TextView;

    .line 61
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    iget-object v1, v1, Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;->text:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 62
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    iget-object v1, v1, Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;->text:Landroid/widget/TextView;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 63
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 68
    :goto_0
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->updateText()V

    .line 69
    return-object v0

    .line 65
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    move-object v0, p1

    .line 66
    .restart local v0    # "view":Landroid/view/View;
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemCharity$ViewHolder;

    goto :goto_0
.end method

.method public isHidden()Z
    .locals 3

    .prologue
    .line 132
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    if-eqz v1, :cond_0

    .line 133
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mIsHiddenCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v1}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 138
    :goto_0
    return v1

    .line 135
    :catch_0
    move-exception v0

    .line 136
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "AmazonSmile the menu of charity hidden call error and catch exception"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 138
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 2
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 104
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemBase;->onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V

    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    if-eqz v0, :cond_0

    .line 106
    const/4 v0, 0x1

    new-instance v1, Lcom/amazon/mShop/gno/GNODrawerItemCharity$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemCharity$2;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemCharity;Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V

    invoke-static {p1, v0, v1}, Lcom/amazon/mShop/gno/GNODrawerHelper;->closeDrawerAndExecute(Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/Runnable;)V

    .line 113
    :cond_0
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 121
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->updateText()V

    .line 122
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 126
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->updateText()V

    .line 127
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 116
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemCharity;->updateText()V

    .line 117
    return-void
.end method
