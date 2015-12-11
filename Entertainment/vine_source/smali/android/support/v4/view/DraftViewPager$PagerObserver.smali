.class Landroid/support/v4/view/DraftViewPager$PagerObserver;
.super Landroid/database/DataSetObserver;
.source "DraftViewPager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/view/DraftViewPager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PagerObserver"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/support/v4/view/DraftViewPager;


# direct methods
.method private constructor <init>(Landroid/support/v4/view/DraftViewPager;)V
    .locals 0

    .prologue
    .line 2081
    iput-object p1, p0, Landroid/support/v4/view/DraftViewPager$PagerObserver;->this$0:Landroid/support/v4/view/DraftViewPager;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/support/v4/view/DraftViewPager;Landroid/support/v4/view/DraftViewPager$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/view/DraftViewPager;
    .param p2, "x1"    # Landroid/support/v4/view/DraftViewPager$1;

    .prologue
    .line 2081
    invoke-direct {p0, p1}, Landroid/support/v4/view/DraftViewPager$PagerObserver;-><init>(Landroid/support/v4/view/DraftViewPager;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 1

    .prologue
    .line 2084
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager$PagerObserver;->this$0:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/DraftViewPager;->dataSetChanged()V

    .line 2085
    return-void
.end method

.method public onInvalidated()V
    .locals 1

    .prologue
    .line 2089
    iget-object v0, p0, Landroid/support/v4/view/DraftViewPager$PagerObserver;->this$0:Landroid/support/v4/view/DraftViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/DraftViewPager;->dataSetChanged()V

    .line 2090
    return-void
.end method
