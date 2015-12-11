.class public Lamazon/communication/identity/UrlEndpointIdentity;
.super Lamazon/communication/identity/EndpointIdentity;
.source "UrlEndpointIdentity.java"


# instance fields
.field private final mUrn:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "urn"    # Ljava/lang/String;

    .prologue
    .line 23
    invoke-direct {p0}, Lamazon/communication/identity/EndpointIdentity;-><init>()V

    .line 24
    iput-object p1, p0, Lamazon/communication/identity/UrlEndpointIdentity;->mUrn:Ljava/lang/String;

    .line 25
    return-void
.end method


# virtual methods
.method public toLogSafeString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    const-string/jumbo v0, "URNs may contain PII"

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lamazon/communication/identity/UrlEndpointIdentity;->mUrn:Ljava/lang/String;

    return-object v0
.end method
