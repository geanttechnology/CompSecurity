.class public Lcom/wjj/adapter/base/JunkCanliuAdapter;
.super Lcom/wjj/adapter/base/MyBaseAdapter;
.source "JunkCanliuAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/wjj/adapter/base/MyBaseAdapter",
        "<",
        "Lcom/wjj/eneity/Canliu;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/wjj/adapter/base/MyBaseAdapter;-><init>(Landroid/content/Context;)V

    .line 18
    return-void
.end method


# virtual methods
.method public MygetView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 23
    if-nez p2, :cond_0

    .line 24
    iget-object v2, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter;->inflater:Landroid/view/LayoutInflater;

    const v3, 0x7f030062

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 25
    new-instance v1, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;

    invoke-direct {v1, p0, p2}, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;-><init>(Lcom/wjj/adapter/base/JunkCanliuAdapter;Landroid/view/View;)V

    .line 26
    .local v1, "viewholder":Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 30
    :goto_0
    iget-object v2, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wjj/eneity/Canliu;

    .line 31
    .local v0, "cl":Lcom/wjj/eneity/Canliu;
    iget-object v2, v1, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 33
    iget-object v2, v1, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->name:Landroid/widget/TextView;

    iget-object v3, v0, Lcom/wjj/eneity/Canliu;->runingsoftname:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 34
    iget-object v2, v1, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->size:Landroid/widget/TextView;

    new-instance v3, Ljava/lang/StringBuilder;

    iget-wide v4, v0, Lcom/wjj/eneity/Canliu;->memory:J

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 35
    iget-object v2, v1, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    iget-boolean v3, v0, Lcom/wjj/eneity/Canliu;->ischecked:Z

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 38
    return-object p2

    .line 28
    .end local v0    # "cl":Lcom/wjj/eneity/Canliu;
    .end local v1    # "viewholder":Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;

    .restart local v1    # "viewholder":Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;
    goto :goto_0
.end method
