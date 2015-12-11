.class public final Ltm;
.super Ltx;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lor;


# direct methods
.method public constructor <init>(Lor;)V
    .locals 0

    invoke-direct {p0}, Ltx;-><init>()V

    iput-object p1, p0, Ltm;->a:Lor;

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Ltm;->a:Lor;

    invoke-interface {v0, p1, p2}, Lor;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
