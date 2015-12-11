.class public abstract Lcom/google/android/gms/internal/kf;
.super Ljava/lang/Object;


# instance fields
.field protected f:I


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/gms/internal/kf;->f:I

    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/internal/kf;->f:I

    return v0
.end method

.method public abstract a(Lcom/google/android/gms/internal/kd;)V
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    invoke-static {p0}, Lcom/google/android/gms/internal/kh;->a(Lcom/google/android/gms/internal/kf;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
