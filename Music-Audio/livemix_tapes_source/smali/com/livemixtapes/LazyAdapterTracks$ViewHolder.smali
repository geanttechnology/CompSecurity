.class Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;
.super Ljava/lang/Object;
.source "LazyAdapterTracks.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/LazyAdapterTracks;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ViewHolder"
.end annotation


# instance fields
.field downloadBtn:Landroid/widget/ImageButton;

.field id:Landroid/widget/TextView;

.field progressBar:Landroid/widget/ProgressBar;

.field selectionView:Landroid/view/View;

.field title:Landroid/widget/TextView;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
