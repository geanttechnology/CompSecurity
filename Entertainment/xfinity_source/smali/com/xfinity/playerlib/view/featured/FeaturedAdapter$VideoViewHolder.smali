.class public Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;
.super Ljava/lang/Object;
.source "FeaturedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "VideoViewHolder"
.end annotation


# instance fields
.field public container:Landroid/view/View;

.field public lockedIndicator:Landroid/widget/ImageView;

.field public networkLogo:Landroid/widget/ImageView;

.field public placeholderTitle:Landroid/widget/TextView;

.field public videoImage:Landroid/widget/ImageView;


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 240
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
