.class public final Lcom/google/android/gms/location/e;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/b;


# instance fields
.field public final a:Lcom/google/android/gms/internal/iu;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/iu;

    const-string v1, "location"

    invoke-direct {v0, p1, p2, p3, v1}, Lcom/google/android/gms/internal/iu;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    return-void
.end method


# virtual methods
.method public final a()Landroid/location/Location;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    iget-object v0, v0, Lcom/google/android/gms/internal/iu;->f:Lcom/google/android/gms/internal/ir;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ir;->a()Landroid/location/Location;

    move-result-object v0

    return-object v0
.end method
