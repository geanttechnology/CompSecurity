.class public Lcom/penthera/virtuososdk/download/MD5State;
.super Ljava/lang/Object;
.source "MD5State.java"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field bitCount:J

.field buffer:[B

.field state:[I

.field valid:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->valid:Z

    .line 41
    const/4 v0, 0x4

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    .line 53
    const/16 v0, 0x40

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->buffer:[B

    .line 63
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/MD5State;->reset()V

    .line 64
    return-void
.end method


# virtual methods
.method public copy(Lcom/penthera/virtuososdk/download/MD5State;)V
    .locals 4
    .param p1, "from"    # Lcom/penthera/virtuososdk/download/MD5State;

    .prologue
    const/4 v3, 0x0

    .line 97
    iget-object v0, p1, Lcom/penthera/virtuososdk/download/MD5State;->buffer:[B

    iget-object v1, p0, Lcom/penthera/virtuososdk/download/MD5State;->buffer:[B

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/MD5State;->buffer:[B

    array-length v2, v2

    invoke-static {v0, v3, v1, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 98
    iget-object v0, p1, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    iget-object v1, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    array-length v2, v2

    invoke-static {v0, v3, v1, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 99
    iget-boolean v0, p1, Lcom/penthera/virtuososdk/download/MD5State;->valid:Z

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->valid:Z

    .line 100
    iget-wide v0, p1, Lcom/penthera/virtuososdk/download/MD5State;->bitCount:J

    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->bitCount:J

    .line 101
    return-void
.end method

.method reset()V
    .locals 3

    .prologue
    .line 29
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v1, 0x0

    const v2, 0x67452301

    aput v2, v0, v1

    .line 30
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v1, 0x1

    const v2, -0x10325477

    aput v2, v0, v1

    .line 31
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v1, 0x2

    const v2, -0x67452302

    aput v2, v0, v1

    .line 32
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v1, 0x3

    const v2, 0x10325476

    aput v2, v0, v1

    .line 34
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/MD5State;->bitCount:J

    .line 35
    return-void
.end method
