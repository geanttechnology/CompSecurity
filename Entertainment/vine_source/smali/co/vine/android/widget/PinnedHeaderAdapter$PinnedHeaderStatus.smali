.class public Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;
.super Ljava/lang/Object;
.source "PinnedHeaderAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/PinnedHeaderAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PinnedHeaderStatus"
.end annotation


# instance fields
.field public pinnedHeaderIsVisible:Z

.field public pinnedHeaderOffset:I

.field public shouldRequestNewView:Z


# direct methods
.method public constructor <init>(IZZ)V
    .locals 0
    .param p1, "offset"    # I
    .param p2, "newView"    # Z
    .param p3, "isVisible"    # Z

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput p1, p0, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;->pinnedHeaderOffset:I

    .line 20
    iput-boolean p2, p0, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;->shouldRequestNewView:Z

    .line 21
    iput-boolean p3, p0, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;->pinnedHeaderIsVisible:Z

    .line 22
    return-void
.end method
