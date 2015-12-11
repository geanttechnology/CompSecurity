.class public Lcom/amazon/mShop/gno/GNODrawerItemSimple;
.super Lcom/amazon/mShop/gno/GNODrawerItemBase;
.source "GNODrawerItemSimple.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;,
        Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;,
        Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field protected mContext:Landroid/content/Context;

.field private mId:Ljava/lang/String;

.field private mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

.field private mSubViewId:I

.field private mText:Ljava/lang/String;

.field private mTextId:I

.field private mType:Lcom/amazon/mShop/gno/GNODrawerItem$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->TAG:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemBase;-><init>()V

    .line 31
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mContext:Landroid/content/Context;

    .line 32
    iput-object p2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mId:Ljava/lang/String;

    .line 33
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/gno/GNODrawerItemSimple;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .param p1, "x1"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    return-object p1
.end method

.method static synthetic access$202(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .param p1, "x1"    # Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mType:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    return-object p1
.end method

.method static synthetic access$302(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mText:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$402(Lcom/amazon/mShop/gno/GNODrawerItemSimple;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .param p1, "x1"    # I

    .prologue
    .line 19
    iput p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mTextId:I

    return p1
.end method

.method static synthetic access$502(Lcom/amazon/mShop/gno/GNODrawerItemSimple;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .param p1, "x1"    # I

    .prologue
    .line 19
    iput p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mSubViewId:I

    return p1
.end method

.method public static builder(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 37
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    invoke-direct {v0, p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mId:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mType:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    return-object v0
.end method

.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "root"    # Landroid/view/ViewGroup;

    .prologue
    .line 53
    if-nez p1, :cond_1

    .line 54
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mContext:Landroid/content/Context;

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->getType()Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->getLayoutId()I

    move-result v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 56
    .local v1, "view":Landroid/view/View;
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;)V

    .line 57
    .local v0, "holder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->drawer_item_title:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;->text:Landroid/widget/TextView;

    .line 58
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->drawer_item_sub_view_container:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/FrameLayout;

    iput-object v2, v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;->subViewWrapper:Landroid/widget/FrameLayout;

    .line 60
    invoke-virtual {v1, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 66
    :goto_0
    iget v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mTextId:I

    if-eqz v2, :cond_2

    .line 67
    iget-object v2, v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;->text:Landroid/widget/TextView;

    iget v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mTextId:I

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(I)V

    .line 73
    :goto_1
    iget v2, v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;->subViewId:I

    iget v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mSubViewId:I

    if-eq v2, v3, :cond_0

    .line 74
    iget v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mSubViewId:I

    iput v2, v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;->subViewId:I

    .line 75
    iget-object v2, v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;->subViewWrapper:Landroid/widget/FrameLayout;

    invoke-virtual {v2}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 76
    iget v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mSubViewId:I

    if-eqz v2, :cond_0

    .line 78
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mContext:Landroid/content/Context;

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    iget v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mSubViewId:I

    iget-object v4, v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;->subViewWrapper:Landroid/widget/FrameLayout;

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 82
    :cond_0
    return-object v1

    .line 62
    .end local v0    # "holder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;
    .end local v1    # "view":Landroid/view/View;
    :cond_1
    move-object v1, p1

    .line 63
    .restart local v1    # "view":Landroid/view/View;
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;

    .restart local v0    # "holder":Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;
    goto :goto_0

    .line 69
    :cond_2
    iget-object v2, v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;->text:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mText:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1
.end method

.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 4
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 87
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemBase;->onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V

    .line 90
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    if-eqz v2, :cond_0

    .line 93
    const-string/jumbo v2, "mshop:exit"

    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 95
    .local v0, "isExitItem":Z
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mId:Ljava/lang/String;

    const-string/jumbo v3, "android:debug/weblab_overrides"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    .line 97
    .local v1, "isWeblabOverrideDebugMenu":Z
    if-nez v0, :cond_1

    if-nez v1, :cond_1

    const/4 v2, 0x1

    :goto_0
    new-instance v3, Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;

    invoke-direct {v3, p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V

    invoke-static {p1, v2, v3}, Lcom/amazon/mShop/gno/GNODrawerHelper;->closeDrawerAndExecute(Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/Runnable;)V

    .line 104
    .end local v0    # "isExitItem":Z
    .end local v1    # "isWeblabOverrideDebugMenu":Z
    :cond_0
    return-void

    .line 97
    .restart local v0    # "isExitItem":Z
    .restart local v1    # "isWeblabOverrideDebugMenu":Z
    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method
