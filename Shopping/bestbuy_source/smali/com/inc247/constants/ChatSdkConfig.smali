.class public Lcom/inc247/constants/ChatSdkConfig;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static CheckAvailbilityUrl:Ljava/lang/String;

.field public static URL:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-string v0, "https://d1af033869koo7.cloudfront.net/psp/optus/native/index.html"

    sput-object v0, Lcom/inc247/constants/ChatSdkConfig;->URL:Ljava/lang/String;

    .line 12
    const-string v0, "http://54.200.148.163/livechatsdk/check_availability.xml"

    sput-object v0, Lcom/inc247/constants/ChatSdkConfig;->CheckAvailbilityUrl:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
