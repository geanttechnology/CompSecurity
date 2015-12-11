.class public final Lvz;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field public final a:I

.field public final b:Lvu;

.field public final c:Lwg;

.field public final d:Ljava/lang/String;

.field public final e:Lvx;


# direct methods
.method public constructor <init>(I)V
    .locals 6

    const/4 v1, 0x0

    move-object v0, p0

    move-object v2, v1

    move-object v3, v1

    move-object v4, v1

    move v5, p1

    invoke-direct/range {v0 .. v5}, Lvz;-><init>(Lvu;Lwg;Ljava/lang/String;Lvx;I)V

    return-void
.end method

.method public constructor <init>(Lvu;Lwg;Ljava/lang/String;Lvx;I)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lvz;->b:Lvu;

    iput-object p2, p0, Lvz;->c:Lwg;

    iput-object p3, p0, Lvz;->d:Ljava/lang/String;

    iput-object p4, p0, Lvz;->e:Lvx;

    iput p5, p0, Lvz;->a:I

    return-void
.end method
