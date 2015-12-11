.class public final Lup;
.super Lun;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lou;


# direct methods
.method public constructor <init>(Lou;)V
    .locals 0

    invoke-direct {p0}, Lun;-><init>()V

    iput-object p1, p0, Lup;->a:Lou;

    return-void
.end method


# virtual methods
.method public a(Luj;)V
    .locals 2

    iget-object v0, p0, Lup;->a:Lou;

    new-instance v1, Lui;

    invoke-direct {v1, p1}, Lui;-><init>(Luj;)V

    invoke-interface {v0, v1}, Lou;->a(Lot;)V

    return-void
.end method
