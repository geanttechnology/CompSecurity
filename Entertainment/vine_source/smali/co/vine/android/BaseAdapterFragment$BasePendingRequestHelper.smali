.class public Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;
.super Lco/vine/android/PendingRequestHelper;
.source "BaseAdapterFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/BaseAdapterFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "BasePendingRequestHelper"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/BaseAdapterFragment;


# direct methods
.method protected constructor <init>(Lco/vine/android/BaseAdapterFragment;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;->this$0:Lco/vine/android/BaseAdapterFragment;

    invoke-direct {p0}, Lco/vine/android/PendingRequestHelper;-><init>()V

    return-void
.end method


# virtual methods
.method public hideProgress(I)V
    .locals 1
    .param p1, "progressType"    # I

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;->this$0:Lco/vine/android/BaseAdapterFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/BaseAdapterFragment;->hideProgress(I)V

    .line 37
    return-void
.end method

.method public showProgress(I)V
    .locals 1
    .param p1, "progressType"    # I

    .prologue
    .line 31
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;->this$0:Lco/vine/android/BaseAdapterFragment;

    invoke-virtual {v0, p1}, Lco/vine/android/BaseAdapterFragment;->showProgress(I)V

    .line 32
    return-void
.end method
