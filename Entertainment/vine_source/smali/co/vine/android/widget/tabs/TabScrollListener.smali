.class public Lco/vine/android/widget/tabs/TabScrollListener;
.super Ljava/lang/Object;
.source "TabScrollListener.java"


# instance fields
.field private final mActivity:Lco/vine/android/BaseControllerActionBarActivity;

.field private final mTabIndex:I


# direct methods
.method public constructor <init>(Lco/vine/android/BaseControllerActionBarActivity;I)V
    .locals 0
    .param p1, "activity"    # Lco/vine/android/BaseControllerActionBarActivity;
    .param p2, "position"    # I

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput p2, p0, Lco/vine/android/widget/tabs/TabScrollListener;->mTabIndex:I

    .line 14
    iput-object p1, p0, Lco/vine/android/widget/tabs/TabScrollListener;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;

    .line 15
    return-void
.end method


# virtual methods
.method public onScrollFirstItem()V
    .locals 0

    .prologue
    .line 19
    return-void
.end method
