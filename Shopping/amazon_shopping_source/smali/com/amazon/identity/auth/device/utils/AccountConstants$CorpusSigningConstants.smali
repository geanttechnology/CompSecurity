.class public Lcom/amazon/identity/auth/device/utils/AccountConstants$CorpusSigningConstants;
.super Ljava/lang/Object;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CorpusSigningConstants"
.end annotation


# static fields
.field public static final KEY_ADP_AUTH_DIGEST:Ljava/lang/String; = "digest"

.field public static final KEY_ADP_AUTH_TOKEN:Ljava/lang/String; = "token"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 523
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
