.class public interface abstract Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable;
.implements Lcom/google/android/gms/common/data/d;
.implements Lcom/google/android/gms/games/multiplayer/f;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable;",
        "Lcom/google/android/gms/common/data/d",
        "<",
        "Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;",
        ">;",
        "Lcom/google/android/gms/games/multiplayer/f;"
    }
.end annotation


# static fields
.field public static final a_:[I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;->a_:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x0
        0x1
        0x2
        0x3
    .end array-data
.end method


# virtual methods
.method public abstract b()Lcom/google/android/gms/games/Game;
.end method

.method public abstract c()Ljava/lang/String;
.end method

.method public abstract d()Ljava/lang/String;
.end method

.method public abstract e()J
.end method

.method public abstract f()I
.end method

.method public abstract g()I
.end method

.method public abstract h()I
.end method

.method public abstract j()Ljava/lang/String;
.end method

.method public abstract k()J
.end method

.method public abstract l()Ljava/lang/String;
.end method

.method public abstract m()[B
.end method

.method public abstract n()I
.end method

.method public abstract o()Ljava/lang/String;
.end method

.method public abstract p()[B
.end method

.method public abstract q()I
.end method

.method public abstract r()Landroid/os/Bundle;
.end method

.method public abstract s()I
.end method

.method public abstract t()Z
.end method
