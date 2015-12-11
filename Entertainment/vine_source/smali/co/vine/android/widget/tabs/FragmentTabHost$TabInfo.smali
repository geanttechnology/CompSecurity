.class Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;
.super Lco/vine/android/widget/tabs/TabInfo;
.source "FragmentTabHost.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/tabs/FragmentTabHost;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "TabInfo"
.end annotation


# instance fields
.field private fragment:Landroid/support/v4/app/Fragment;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "tag"    # Ljava/lang/String;
    .param p3, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 75
    .local p2, "clss":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0, p2, p3, p1}, Lco/vine/android/widget/tabs/TabInfo;-><init>(Ljava/lang/Class;Landroid/os/Bundle;Ljava/lang/String;)V

    .line 76
    return-void
.end method

.method static synthetic access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    .prologue
    .line 70
    iget-object v0, p0, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;

    return-object v0
.end method

.method static synthetic access$102(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/Fragment;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;
    .param p1, "x1"    # Landroid/support/v4/app/Fragment;

    .prologue
    .line 70
    iput-object p1, p0, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;

    return-object p1
.end method
