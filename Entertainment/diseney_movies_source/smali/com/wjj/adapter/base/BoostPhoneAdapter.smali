.class public Lcom/wjj/adapter/base/BoostPhoneAdapter;
.super Lcom/wjj/adapter/base/MyBaseAdapter;
.source "BoostPhoneAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/wjj/adapter/base/MyBaseAdapter",
        "<",
        "Lcom/wjj/eneity/RuningApp;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/wjj/adapter/base/MyBaseAdapter;-><init>(Landroid/content/Context;)V

    .line 20
    return-void
.end method


# virtual methods
.method public MygetView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 25
    if-nez p2, :cond_0

    .line 26
    iget-object v2, p0, Lcom/wjj/adapter/base/BoostPhoneAdapter;->inflater:Landroid/view/LayoutInflater;

    const v3, 0x7f03005e

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 27
    new-instance v1, Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;

    invoke-direct {v1, p0, p2}, Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;-><init>(Lcom/wjj/adapter/base/BoostPhoneAdapter;Landroid/view/View;)V

    .line 28
    .local v1, "viewholder":Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 32
    :goto_0
    iget-object v2, p0, Lcom/wjj/adapter/base/BoostPhoneAdapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wjj/eneity/RuningApp;

    .line 33
    .local v0, "sw":Lcom/wjj/eneity/RuningApp;
    iget-object v2, v1, Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 35
    iget-object v2, v1, Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;->tv_appname:Landroid/widget/TextView;

    iget-object v3, v0, Lcom/wjj/eneity/RuningApp;->runingsoftname:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 36
    iget-object v2, v1, Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;->iv_icon:Landroid/widget/ImageView;

    iget-object v3, v0, Lcom/wjj/eneity/RuningApp;->icon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 37
    iget-object v2, v1, Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;->tv_appsize:Landroid/widget/TextView;

    iget-wide v3, v0, Lcom/wjj/eneity/RuningApp;->memory:J

    invoke-static {v3, v4}, Lcom/wjj/manager/CommonUtil;->formatSizeDanwei(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 38
    iget-object v2, v1, Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    iget-boolean v3, v0, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 41
    return-object p2

    .line 30
    .end local v0    # "sw":Lcom/wjj/eneity/RuningApp;
    .end local v1    # "viewholder":Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;

    .restart local v1    # "viewholder":Lcom/wjj/adapter/base/BoostPhoneAdapter$ViewHolder;
    goto :goto_0
.end method
