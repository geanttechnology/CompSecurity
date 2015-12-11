.class public Lcom/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus;
.super Ljava/lang/Object;
.source "DeferredDeepLinkManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/DeferredDeepLinkManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BranchDeepLinkStatus"
.end annotation


# instance fields
.field clicked_branch_link:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "+clicked_branch_link"
    .end annotation
.end field

.field is_first_session:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "+is_first_session"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
