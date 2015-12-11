.class public Lcom/wjj/adapter/base/ApkSoftAdapter;
.super Lcom/wjj/adapter/base/MyBaseAdapter;
.source "ApkSoftAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/wjj/adapter/base/MyBaseAdapter",
        "<",
        "Lcom/wjj/eneity/SoftApk;",
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

.method public static roundDouble(DI)Ljava/lang/Double;
    .locals 8
    .param p0, "val"    # D
    .param p2, "precision"    # I

    .prologue
    .line 78
    const/4 v3, 0x0

    .line 80
    .local v3, "ret":Ljava/lang/Double;
    const-wide/high16 v4, 0x4024000000000000L    # 10.0

    int-to-double v6, p2

    :try_start_0
    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v1

    .line 81
    .local v1, "factor":D
    mul-double v4, p0, v1

    const-wide/high16 v6, 0x3fe0000000000000L    # 0.5

    add-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    div-double/2addr v4, v1

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 85
    .end local v1    # "factor":D
    :goto_0
    return-object v3

    .line 82
    :catch_0
    move-exception v0

    .line 83
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public MygetView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 26
    if-nez p2, :cond_0

    .line 27
    iget-object v2, p0, Lcom/wjj/adapter/base/ApkSoftAdapter;->inflater:Landroid/view/LayoutInflater;

    const v3, 0x7f03005d

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 28
    new-instance v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;

    invoke-direct {v1, p0, p2}, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;-><init>(Lcom/wjj/adapter/base/ApkSoftAdapter;Landroid/view/View;)V

    .line 29
    .local v1, "viewholder":Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 33
    :goto_0
    iget-object v2, p0, Lcom/wjj/adapter/base/ApkSoftAdapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wjj/eneity/SoftApk;

    .line 34
    .local v0, "sw":Lcom/wjj/eneity/SoftApk;
    iget-object v2, v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 37
    iget-object v2, v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->tv_softname:Landroid/widget/TextView;

    iget-object v3, v0, Lcom/wjj/eneity/SoftApk;->apkname:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 38
    iget-object v2, v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->iv_icon:Landroid/widget/ImageView;

    iget-object v3, v0, Lcom/wjj/eneity/SoftApk;->icon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 41
    iget-object v2, v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->tv_softsizi:Landroid/widget/TextView;

    iget-wide v3, v0, Lcom/wjj/eneity/SoftApk;->apksize:J

    invoke-static {v3, v4}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 43
    iget-object v2, v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->soft_version:Landroid/widget/TextView;

    iget-object v3, v0, Lcom/wjj/eneity/SoftApk;->apkversioncode:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 45
    iget-object v2, v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    iget-boolean v3, v0, Lcom/wjj/eneity/SoftApk;->ischecked:Z

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 51
    return-object p2

    .line 31
    .end local v0    # "sw":Lcom/wjj/eneity/SoftApk;
    .end local v1    # "viewholder":Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;

    .restart local v1    # "viewholder":Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;
    goto :goto_0
.end method
