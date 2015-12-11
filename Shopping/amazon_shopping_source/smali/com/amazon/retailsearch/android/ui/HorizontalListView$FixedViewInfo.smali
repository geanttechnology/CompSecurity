.class public Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
.super Ljava/lang/Object;
.source "HorizontalListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/HorizontalListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "FixedViewInfo"
.end annotation


# instance fields
.field public data:Ljava/lang/Object;

.field public isSelectable:Z

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

.field public view:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V
    .locals 0

    .prologue
    .line 1102
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
