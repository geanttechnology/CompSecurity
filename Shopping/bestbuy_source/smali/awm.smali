.class public final Lawm;
.super Lrl;

# interfaces
.implements Latv;


# instance fields
.field private final c:I


# direct methods
.method public constructor <init>(Lcom/google/android/gms/common/data/DataHolder;II)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lrl;-><init>(Lcom/google/android/gms/common/data/DataHolder;I)V

    iput p3, p0, Lawm;->c:I

    return-void
.end method


# virtual methods
.method public synthetic a()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lawm;->d()Latv;

    move-result-object v0

    return-object v0
.end method

.method public b()Latx;
    .locals 4

    new-instance v0, Laws;

    iget-object v1, p0, Lawm;->a:Lcom/google/android/gms/common/data/DataHolder;

    iget v2, p0, Lawm;->b:I

    iget v3, p0, Lawm;->c:I

    invoke-direct {v0, v1, v2, v3}, Laws;-><init>(Lcom/google/android/gms/common/data/DataHolder;II)V

    return-object v0
.end method

.method public c()I
    .locals 1

    const-string v0, "event_type"

    invoke-virtual {p0, v0}, Lawm;->a(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public d()Latv;
    .locals 1

    new-instance v0, Lawl;

    invoke-direct {v0, p0}, Lawl;-><init>(Latv;)V

    return-object v0
.end method
