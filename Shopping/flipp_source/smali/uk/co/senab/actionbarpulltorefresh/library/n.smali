.class final Luk/co/senab/actionbarpulltorefresh/library/n;
.super Landroid/widget/FrameLayout$LayoutParams;
.source "SourceFile"


# instance fields
.field final a:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2

    .prologue
    .line 236
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 238
    sget-object v0, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshView:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 239
    sget v1, Luk/co/senab/actionbarpulltorefresh/library/v;->PullToRefreshView_ptrViewDelegateClass:I

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Luk/co/senab/actionbarpulltorefresh/library/n;->a:Ljava/lang/String;

    .line 241
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 242
    return-void
.end method
