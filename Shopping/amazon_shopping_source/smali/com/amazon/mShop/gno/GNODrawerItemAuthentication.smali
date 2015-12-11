.class public Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;
.super Lcom/amazon/mShop/gno/GNODrawerItemBase;
.source "GNODrawerItemAuthentication.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;
    }
.end annotation


# static fields
.field private static final REF_MARKERS:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mId:I

.field private mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 27
    const-class v0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->TAG:Ljava/lang/String;

    .line 32
    new-instance v0, Landroid/util/SparseArray;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Landroid/util/SparseArray;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->REF_MARKERS:Landroid/util/SparseArray;

    .line 33
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->REF_MARKERS:Landroid/util/SparseArray;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_signin:I

    const-string/jumbo v2, "gno_si"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    .line 34
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->REF_MARKERS:Landroid/util/SparseArray;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_signout:I

    const-string/jumbo v2, "gno_so"

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemBase;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    .line 44
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 45
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;

    .prologue
    .line 26
    iget v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    return v0
.end method

.method private calcTextViewWidth()I
    .locals 3

    .prologue
    .line 171
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->gno_menu_width:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 172
    .local v0, "width":I
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->gno_menu_item_padding_left_right:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    mul-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    .line 173
    return v0
.end method

.method private chopText()Ljava/lang/String;
    .locals 14

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 133
    const/4 v7, 0x0

    .line 135
    .local v7, "string":Ljava/lang/String;
    iget-object v10, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    if-eqz v10, :cond_2

    .line 136
    iget-object v10, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/amazon/mShop/android/lib/R$string;->gno_sign_out:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 137
    .local v2, "format":Ljava/lang/String;
    iget-object v10, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/amazon/mShop/android/lib/R$string;->gno_sign_out_new_line:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 138
    .local v3, "format_new_line":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v9

    .line 140
    .local v9, "user":Ljava/lang/String;
    iget-object v10, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    iget-object v10, v10, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;->text:Landroid/widget/TextView;

    invoke-virtual {v10}, Landroid/widget/TextView;->getWidth()I

    move-result v8

    .line 142
    .local v8, "textViewWidth":I
    if-nez v8, :cond_0

    .line 143
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->calcTextViewWidth()I

    move-result v8

    .line 146
    :cond_0
    iget-object v10, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    iget-object v10, v10, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;->text:Landroid/widget/TextView;

    invoke-virtual {v10}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v5

    .line 147
    .local v5, "paint":Landroid/text/TextPaint;
    new-array v10, v13, [Ljava/lang/Object;

    aput-object v9, v10, v12

    invoke-static {v2, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 148
    invoke-virtual {v5, v7}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v10

    int-to-float v11, v8

    cmpl-float v10, v10, v11

    if-lez v10, :cond_2

    .line 149
    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v4

    .local v4, "k":I
    :goto_0
    if-lez v4, :cond_2

    .line 150
    new-array v10, v13, [Ljava/lang/Object;

    invoke-virtual {v9, v12, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v3, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 152
    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v10

    if-ne v4, v10, :cond_1

    .line 153
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 154
    .local v0, "builder":Ljava/lang/StringBuilder;
    const-string/jumbo v10, "\u2026"

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->lastIndexOf(Ljava/lang/String;)I

    move-result v1

    .line 155
    .local v1, "ellipsis":I
    const/4 v10, -0x1

    if-eq v1, v10, :cond_1

    .line 156
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 160
    .end local v0    # "builder":Ljava/lang/StringBuilder;
    .end local v1    # "ellipsis":I
    :cond_1
    const-string/jumbo v10, "\n"

    invoke-virtual {v7, v10}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v7, v12, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    .line 161
    .local v6, "s_before_new_line":Ljava/lang/String;
    invoke-virtual {v5, v6}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v10

    int-to-float v11, v8

    cmpg-float v10, v10, v11

    if-gez v10, :cond_3

    .line 167
    .end local v2    # "format":Ljava/lang/String;
    .end local v3    # "format_new_line":Ljava/lang/String;
    .end local v4    # "k":I
    .end local v5    # "paint":Landroid/text/TextPaint;
    .end local v6    # "s_before_new_line":Ljava/lang/String;
    .end local v8    # "textViewWidth":I
    .end local v9    # "user":Ljava/lang/String;
    :cond_2
    return-object v7

    .line 149
    .restart local v2    # "format":Ljava/lang/String;
    .restart local v3    # "format_new_line":Ljava/lang/String;
    .restart local v4    # "k":I
    .restart local v5    # "paint":Landroid/text/TextPaint;
    .restart local v6    # "s_before_new_line":Ljava/lang/String;
    .restart local v8    # "textViewWidth":I
    .restart local v9    # "user":Ljava/lang/String;
    :cond_3
    add-int/lit8 v4, v4, -0x1

    goto :goto_0
.end method

.method private getText()Ljava/lang/String;
    .locals 4

    .prologue
    .line 101
    const/4 v0, 0x0

    .line 102
    .local v0, "text":Ljava/lang/String;
    iget v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_signin:I

    if-eq v2, v3, :cond_0

    iget v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_sso_signin:I

    if-ne v2, v3, :cond_2

    .line 103
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->gno_sign_in:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 113
    :cond_1
    :goto_0
    return-object v0

    .line 104
    :cond_2
    iget v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_signout:I

    if-eq v2, v3, :cond_3

    iget v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_sso_signout:I

    if-ne v2, v3, :cond_1

    .line 105
    :cond_3
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    .line 106
    .local v1, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v1, :cond_4

    .line 107
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->chopText()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 109
    :cond_4
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->home_sign_out:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private refreshGNODrawer()Z
    .locals 4

    .prologue
    .line 237
    const/4 v2, 0x0

    .line 238
    .local v2, "refreshed":Z
    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    instance-of v3, v3, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v3, :cond_0

    .line 239
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 240
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    .line 241
    .local v1, "drawer":Lcom/amazon/mShop/gno/GNODrawer;
    if-eqz v1, :cond_0

    .line 242
    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawer;->refresh()V

    .line 243
    const/4 v2, 0x1

    .line 246
    .end local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    .end local v1    # "drawer":Lcom/amazon/mShop/gno/GNODrawer;
    :cond_0
    return v2
.end method

.method private setItemId()V
    .locals 2

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 79
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 80
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_signout:I

    iput v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    .line 94
    :goto_0
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->REF_MARKERS:Landroid/util/SparseArray;

    iget v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->setRefMarker(Ljava/lang/String;)V

    .line 95
    return-void

    .line 82
    :cond_0
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_signin:I

    iput v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    goto :goto_0

    .line 87
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAccount()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 88
    :cond_2
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_sso_signout:I

    iput v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    goto :goto_0

    .line 90
    :cond_3
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->feature_menu_sso_signin:I

    iput v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mId:I

    goto :goto_0
.end method

.method private updateText()V
    .locals 3

    .prologue
    .line 120
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    if-eqz v2, :cond_0

    .line 121
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->setItemId()V

    .line 123
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    iget-object v2, v2, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;->text:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    .line 124
    .local v1, "oldText":Ljava/lang/CharSequence;
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->getText()Ljava/lang/String;

    move-result-object v0

    .line 126
    .local v0, "newText":Ljava/lang/CharSequence;
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 127
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    iget-object v2, v2, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;->text:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 130
    .end local v0    # "newText":Ljava/lang/CharSequence;
    .end local v1    # "oldText":Ljava/lang/CharSequence;
    :cond_0
    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 209
    const-string/jumbo v0, "/authentication"

    return-object v0
.end method

.method public getType()Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    .locals 1

    .prologue
    .line 199
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->AUTHENTICATION:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    return-object v0
.end method

.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "root"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v3, 0x0

    .line 50
    if-nez p1, :cond_0

    .line 51
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mContext:Landroid/content/Context;

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_simple:I

    invoke-virtual {v1, v2, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 53
    .local v0, "view":Landroid/view/View;
    new-instance v1, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;)V

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    .line 54
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->drawer_item_title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v2, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;->text:Landroid/widget/TextView;

    .line 55
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    iget-object v1, v1, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;->text:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 56
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    iget-object v1, v1, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;->text:Landroid/widget/TextView;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 58
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 64
    :goto_0
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->updateText()V

    .line 69
    return-object v0

    .line 60
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    move-object v0, p1

    .line 61
    .restart local v0    # "view":Landroid/view/View;
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    iput-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->mViewHolder:Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$ViewHolder;

    goto :goto_0
.end method

.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 3
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 178
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemBase;->onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V

    .line 180
    sget-object v1, Lcom/amazon/mShop/sso/IdentityType;->NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v2

    if-ne v1, v2, :cond_0

    const/4 v0, 0x1

    .line 181
    .local v0, "needPushBlankPage":Z
    :goto_0
    new-instance v1, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication$1;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;Lcom/amazon/mShop/AmazonActivity;)V

    invoke-static {p1, v0, v1}, Lcom/amazon/mShop/gno/GNODrawerHelper;->closeDrawerAndExecute(Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/Runnable;)V

    .line 195
    return-void

    .line 180
    .end local v0    # "needPushBlankPage":Z
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 214
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->updateText()V

    .line 215
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->refreshGNODrawer()Z

    .line 216
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 220
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->updateText()V

    .line 221
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->refreshGNODrawer()Z

    .line 222
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 226
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->updateText()V

    .line 227
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAuthentication;->refreshGNODrawer()Z

    .line 228
    return-void
.end method
