.class final Lfr/castorflex/android/verticalviewpager/j;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/b/c;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/support/v4/b/c",
        "<",
        "Lfr/castorflex/android/verticalviewpager/VerticalViewPager$SavedState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 1134
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final synthetic a(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1134
    new-instance v0, Lfr/castorflex/android/verticalviewpager/VerticalViewPager$SavedState;

    invoke-direct {v0, p1, p2}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager$SavedState;-><init>(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V

    return-object v0
.end method

.method public final bridge synthetic a(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1134
    new-array v0, p1, [Lfr/castorflex/android/verticalviewpager/VerticalViewPager$SavedState;

    return-object v0
.end method
