.class Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;
.super Ljava/lang/Object;
.source "HeaderGridView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FixedViewInfo"
.end annotation


# instance fields
.field public data:Ljava/lang/Object;

.field public isSelectable:Z

.field public view:Landroid/view/View;

.field public viewContainer:Landroid/view/ViewGroup;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$1;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FixedViewInfo;-><init>()V

    return-void
.end method
