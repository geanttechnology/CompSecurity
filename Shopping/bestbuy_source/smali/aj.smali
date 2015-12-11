.class final Laj;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lah;


# direct methods
.method private constructor <init>(Lah;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Laj;->a:Lah;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lah;B)V
    .locals 0

    .prologue
    .line 114
    invoke-direct {p0, p1}, Laj;-><init>(Lah;)V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Laj;->a:Lah;

    invoke-virtual {v0}, Lah;->b()V

    .line 118
    return-void
.end method
