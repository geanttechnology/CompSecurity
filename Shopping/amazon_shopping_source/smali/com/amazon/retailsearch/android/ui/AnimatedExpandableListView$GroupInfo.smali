.class Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
.super Ljava/lang/Object;
.source "AnimatedExpandableListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "GroupInfo"
.end annotation


# instance fields
.field animating:Z

.field dummyHeight:I

.field expanding:Z

.field firstChildPosition:I


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 221
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 222
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->animating:Z

    .line 223
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->expanding:Z

    .line 233
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->dummyHeight:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$1;

    .prologue
    .line 221
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;-><init>()V

    return-void
.end method
