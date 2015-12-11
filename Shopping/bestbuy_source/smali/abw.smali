.class public Labw;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# static fields
.field public static final a:Labx;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Labx",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Labw$1;

    invoke-direct {v0}, Labw$1;-><init>()V

    sput-object v0, Labw;->a:Labx;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Labx;)Ljava/util/concurrent/Future;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Labx",
            "<TT;>;)",
            "Ljava/util/concurrent/Future",
            "<TT;>;"
        }
    .end annotation

    new-instance v0, Labw$2;

    invoke-direct {v0, p0, p1, p2}, Labw$2;-><init>(Labw;Ljava/lang/String;Labx;)V

    invoke-static {v0}, Labp;->a(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
