# MAS - Requirements

Oct 31, 2026 · @Eryk

# Introduction

Modular Automotive System (MAS) is a remote vehicle diagnostics service that informs drivers, fleets and workshops about vehicle faults as soon as they occur. Each fault is translated into a clear description, rated by urgency and kept in the vehicle's service history, so problems are fixed before they become breakdowns. This shortens vehicle downtime, lowers repair costs and gives the manufacturer insight into recurring faults across vehicle models.

# Version history

| Version | Description |
| --- | --- |
| 1.0.0 | Initial version: introduction, stakeholders and functional requirements structure for remote DTC diagnostics. |

# Stakeholders

| Stakeholder | Description |
| --- | --- |
| Diagnostic Engineer | A person who maintains the catalog of fault codes, their descriptions and urgency levels. Analyzes fault trends across vehicle models to support quality improvements. |

# Functional Requirements

## Diagnostic Engineer

### Vehicle Diagnostics

#### Vision

| **Problem** | Diagnostic Engineers cannot diagnose a vehicle remotely and must wait until it physically arrives at a workshop to check its faults. |
| --- | --- |
| **Impact** | Drivers and workshops get unclear fault information, causing unnecessary service visits or ignored critical faults. |
| **Solution** | A central catalog where diagnostic engineers define each fault's description, urgency and recommended action for every vehicle model. |
| **Benefits** | Consistent, clear fault messages for every customer, faster reaction to quality issues and lower warranty and repair costs. |

#### User stories

##### US-0001

AS A Diagnostic Engineer,

I WANT to see a vehicle's active faults remotely,

SO THAT I can diagnose it before it reaches a workshop.

##### US-0002

AS A Diagnostic Engineer,

I WANT to see a vehicle's ignition status remotely,

SO THAT I know if it is ready for diagnosis.
