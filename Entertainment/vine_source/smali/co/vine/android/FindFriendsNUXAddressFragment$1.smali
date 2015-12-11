.class Lco/vine/android/FindFriendsNUXAddressFragment$1;
.super Ljava/lang/Object;
.source "FindFriendsNUXAddressFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/FindFriendsNUXAddressFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/FindFriendsNUXAddressFragment;


# direct methods
.method constructor <init>(Lco/vine/android/FindFriendsNUXAddressFragment;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lco/vine/android/FindFriendsNUXAddressFragment$1;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 153
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$1;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    # getter for: Lco/vine/android/FindFriendsNUXAddressFragment;->mFilterLoaderIsReady:Z
    invoke-static {v0}, Lco/vine/android/FindFriendsNUXAddressFragment;->access$100(Lco/vine/android/FindFriendsNUXAddressFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 154
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$1;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-virtual {v0, v1}, Lco/vine/android/FindFriendsNUXAddressFragment;->initLoader(I)V

    .line 155
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$1;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    # setter for: Lco/vine/android/FindFriendsNUXAddressFragment;->mFilterLoaderIsReady:Z
    invoke-static {v0, v1}, Lco/vine/android/FindFriendsNUXAddressFragment;->access$102(Lco/vine/android/FindFriendsNUXAddressFragment;Z)Z

    .line 159
    :goto_0
    return-void

    .line 157
    :cond_0
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXAddressFragment$1;->this$0:Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-virtual {v0, v1}, Lco/vine/android/FindFriendsNUXAddressFragment;->restartLoader(I)Z

    goto :goto_0
.end method
