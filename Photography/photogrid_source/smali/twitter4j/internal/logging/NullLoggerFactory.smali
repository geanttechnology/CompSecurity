.class final Ltwitter4j/internal/logging/NullLoggerFactory;
.super Ltwitter4j/internal/logging/LoggerFactory;
.source "SourceFile"


# static fields
.field private static final SINGLETON:Ltwitter4j/internal/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    new-instance v0, Ltwitter4j/internal/logging/NullLogger;

    invoke-direct {v0}, Ltwitter4j/internal/logging/NullLogger;-><init>()V

    sput-object v0, Ltwitter4j/internal/logging/NullLoggerFactory;->SINGLETON:Ltwitter4j/internal/logging/Logger;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ltwitter4j/internal/logging/LoggerFactory;-><init>()V

    return-void
.end method


# virtual methods
.method public final getLogger(Ljava/lang/Class;)Ltwitter4j/internal/logging/Logger;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Ltwitter4j/internal/logging/NullLoggerFactory;->SINGLETON:Ltwitter4j/internal/logging/Logger;

    return-object v0
.end method
