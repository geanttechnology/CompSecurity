.class public Lco/vine/android/widget/tabs/TabInfo;
.super Ljava/lang/Object;
.source "TabInfo.java"


# instance fields
.field public final bundle:Landroid/os/Bundle;

.field public final clss:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private mRef:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/support/v4/app/Fragment;",
            ">;"
        }
    .end annotation
.end field

.field protected mTag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/Class;Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 0
    .param p2, "bundle"    # Landroid/os/Bundle;
    .param p3, "tag"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/os/Bundle;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 17
    .local p1, "clss":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lco/vine/android/widget/tabs/TabInfo;->clss:Ljava/lang/Class;

    .line 19
    iput-object p2, p0, Lco/vine/android/widget/tabs/TabInfo;->bundle:Landroid/os/Bundle;

    .line 20
    iput-object p3, p0, Lco/vine/android/widget/tabs/TabInfo;->mTag:Ljava/lang/String;

    .line 21
    return-void
.end method


# virtual methods
.method public fragment()Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabInfo;->mRef:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabInfo;->mRef:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 35
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabInfo;->mTag:Ljava/lang/String;

    return-object v0
.end method

.method public setFragment(Landroid/support/v4/app/Fragment;)V
    .locals 1
    .param p1, "f"    # Landroid/support/v4/app/Fragment;

    .prologue
    .line 24
    if-eqz p1, :cond_0

    .line 25
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lco/vine/android/widget/tabs/TabInfo;->mRef:Ljava/lang/ref/WeakReference;

    .line 29
    :goto_0
    return-void

    .line 27
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/widget/tabs/TabInfo;->mRef:Ljava/lang/ref/WeakReference;

    goto :goto_0
.end method
