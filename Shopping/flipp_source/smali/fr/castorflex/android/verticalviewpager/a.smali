.class final Lfr/castorflex/android/verticalviewpager/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lfr/castorflex/android/verticalviewpager/e;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    .prologue
    .line 87
    check-cast p1, Lfr/castorflex/android/verticalviewpager/e;

    check-cast p2, Lfr/castorflex/android/verticalviewpager/e;

    iget v0, p1, Lfr/castorflex/android/verticalviewpager/e;->b:I

    iget v1, p2, Lfr/castorflex/android/verticalviewpager/e;->b:I

    sub-int/2addr v0, v1

    return v0
.end method
