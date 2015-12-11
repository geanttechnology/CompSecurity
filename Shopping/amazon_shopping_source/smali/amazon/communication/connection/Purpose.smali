.class public final Lamazon/communication/connection/Purpose;
.super Ljava/lang/Object;
.source "Purpose.java"


# static fields
.field public static final REGULAR:Lamazon/communication/connection/Purpose;


# instance fields
.field private final mPurpose:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 22
    new-instance v0, Lamazon/communication/connection/Purpose;

    const-string/jumbo v1, "Regular"

    invoke-direct {v0, v1}, Lamazon/communication/connection/Purpose;-><init>(Ljava/lang/String;)V

    sput-object v0, Lamazon/communication/connection/Purpose;->REGULAR:Lamazon/communication/connection/Purpose;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "purpose"    # Ljava/lang/String;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 34
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "purpose must not be empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_1
    iput-object p1, p0, Lamazon/communication/connection/Purpose;->mPurpose:Ljava/lang/String;

    .line 38
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 56
    if-ne p1, p0, :cond_0

    .line 57
    const/4 v1, 0x1

    .line 64
    :goto_0
    return v1

    .line 59
    :cond_0
    if-eqz p1, :cond_1

    instance-of v1, p1, Lamazon/communication/connection/Purpose;

    if-nez v1, :cond_2

    .line 60
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    :cond_2
    move-object v0, p1

    .line 63
    check-cast v0, Lamazon/communication/connection/Purpose;

    .line 64
    .local v0, "other":Lamazon/communication/connection/Purpose;
    iget-object v1, p0, Lamazon/communication/connection/Purpose;->mPurpose:Ljava/lang/String;

    iget-object v2, v0, Lamazon/communication/connection/Purpose;->mPurpose:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public getPurpose()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lamazon/communication/connection/Purpose;->mPurpose:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lamazon/communication/connection/Purpose;->mPurpose:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lamazon/communication/connection/Purpose;->mPurpose:Ljava/lang/String;

    return-object v0
.end method
